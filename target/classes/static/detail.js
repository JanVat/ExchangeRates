// fields
const btnBack = document.getElementById("ButtonBack");
const data =  JSON.parse(sessionStorage.getItem("ExchangeRateData"));
let params = new URLSearchParams(location.search);


// buttons listeners
btnBack.addEventListener("click", function () {
     window.location.replace("http://localhost:8080/web-exchange-rate-list/listAll");
 });


loadDataIntoTable(params.get('id'), data, document.querySelector("table"));



async function loadDataIntoTable(idURL, data, table){
    const tableBody = table.querySelector("tbody");
    tableBody.innerHTML = "";

    for(objectData of data){
        if(objectData.id == idURL) {
                rowElement = document.createElement("tr")

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.shortName;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.name;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.country;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.move;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.valBuy;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.valSell;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.valMid;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.currBuy;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.currSell;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.currMid;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.cnbMid;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.ecbMid;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.version;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.version;
                rowElement.appendChild(cellElement);

                cellElement = document.createElement("td");
                cellElement.textContent = objectData.validFrom;
                rowElement.appendChild(cellElement);

                tableBody.appendChild(rowElement);
            }
        }
}


