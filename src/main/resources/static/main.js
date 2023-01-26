// fields
const btnURL = document.getElementById("ButtonDataFromURL");
const btnDB = document.getElementById("ButtonDataFromDB");


// buttons listeners
btnURL.addEventListener("click", function () {
     loadIntoMainTable("http://localhost:8080/api/list?usedb=false", document.querySelector("table"));
 });

btnDB.addEventListener("click", function () {
     loadIntoMainTable("http://localhost:8080/api/list?usedb=true", document.querySelector("table"));
  });


// functions


async function loadIntoMainTable(url, table){
    const tableBody = table.querySelector("tbody");

    const response = await fetch(url);
    const data = await response.json();

    //console.log(data);
    sessionStorage.setItem("ExchangeRateData", JSON.stringify(data));
    //console.log(sessionStorage);

    tableBody.innerHTML = "";

    for(objectData of data){
        rowElement = document.createElement("tr")

        cellElement = document.createElement("td");
        cellElement.textContent = objectData.shortName;
        rowElement.appendChild(cellElement);

        cellElement = document.createElement("td");
        cellElement.textContent = objectData.currSell;
        rowElement.appendChild(cellElement);

        cellElement = document.createElement("td");
        cellElement.textContent = objectData.currBuy;
        rowElement.appendChild(cellElement);

        cellElement = document.createElement("td");
        var btn = document.createElement('input');
        btn.type = "button";
        btn.className = "btn-table";
        btn.value = "Detail";
        btn.onclick = (function(objectData) {return function() {redirectDetail(objectData.id);}})(objectData);
        cellElement.appendChild(btn);
        rowElement.appendChild(cellElement);

        tableBody.appendChild(rowElement);
        }
}

function redirectDetail(int){
      window.location.replace('listAll/detail?id='+ int);
}