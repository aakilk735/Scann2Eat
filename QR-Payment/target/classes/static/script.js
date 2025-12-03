const API = "http://localhost:8080";

/* -------------------------------------------
   🔥 10 Food Items (Static Frontend Data)
   Name + Price (10–100) + Image + ID
-------------------------------------------- */
const myFoodItems = [
  { id: 1, name: "Burger", price: 20, imageUrl: "image/burger.png" },
  { id: 2, name: "Pizza", price: 35, imageUrl: "image/pizza.png" },
  { id: 3, name: "Hot Dog", price: 25, imageUrl: "image/hotdog.png" },
  { id: 4, name: "Sandwich", price: 45, imageUrl: "image/sandwich.png" },
  { id: 5, name: "Donut", price: 30, imageUrl: "image/donut.png" },
  { id: 6, name: "Cake", price: 100, imageUrl: "image/cake.png" },
  { id: 7, name: "Fries", price: 15, imageUrl: "image/fries.png" },
  { id: 8, name: "Noodles", price: 50, imageUrl: "image/noodles.png" },
  { id: 9, name: "Cold Drink", price: 40, imageUrl: "image/coldrink.png" },
  { id: 10, name: "Momos", price: 60, imageUrl: "image/momos.png" }
];

/* -------------------------------------------
   🔥 Load Products in Grid (No backend fetch)
-------------------------------------------- */
function loadProducts(){
  const div = document.getElementById("products");
  div.innerHTML = "";

  myFoodItems.forEach(p => {
    const card = document.createElement("div");
    card.className = "card";
    card.innerHTML = `
      <img src="${p.imageUrl}" onerror="this.src='placeholder.svg'"/>
      <h4>${p.name}</h4>
      <p>₹${p.price}</p>
    `;
    card.onclick = () => showQR(p.id, p);
    div.appendChild(card);
  });
}

/* -------------------------------------------
   🔥 Show QR Code (Backend logic SAME)
-------------------------------------------- */
function showQR(id, product){
  fetch(API + `/api/products/${id}/qrcode`)
    .then(r => r.json())
    .then(d => {
      document.getElementById("modalTitle").innerText =
        product.name + " - ₹" + product.price;

      document.getElementById("qrImage").src =
        "data:image/png;base64," + d.qrCode;

      document.getElementById("upiText").innerText = d.upi;

      document.getElementById("qrModal").style.display = "flex";

      const btn = document.getElementById("simulateBtn");
      btn.onclick = () => simulatePayment(product);
    });
}

/* -------------------------------------------
   🔥 Payment Simulate (Backend SAME)
-------------------------------------------- */
function simulatePayment(product){
  const payload = {
    productId: product.id,
    amount: product.price,
    transactionId: "SIM" + Date.now(),
    status: "SUCCESS"
  };

  fetch(API + "/api/payment/store", {
    method: "POST",
    headers: { 'Content-Type':'application/json' },
    body: JSON.stringify(payload)
  })
  .then(r => r.json())
  .then(res => {
    alert("Payment simulated and stored with id: " + res.id);
    document.getElementById("qrModal").style.display = "none";
  });
}

/* -------------------------------------------
   🔥 Close Modal
-------------------------------------------- */
document.getElementById("closeBtn").onclick = () =>
  document.getElementById("qrModal").style.display = "none";

/* -------------------------------------------
   🚀 Init
-------------------------------------------- */
loadProducts();
