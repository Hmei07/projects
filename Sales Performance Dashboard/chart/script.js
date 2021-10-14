var dataset1 = [];
var revenueYear = [0, 0, 0, 0, 0]; //index 0 means year 2016 revenue
var revenueMonth = []; //index 0-11 means revenues for months for year 2016
var monthlyRevenue = []; // utk hitung average revenue
var monthlyRevenueCount = []; // pembagi monthlyRevenue
for (var i = 0; i < 60; i++) {
    revenueMonth.push(0)
    monthlyRevenueCount.push(0)
    monthlyRevenue.push(0)
}
var revenueWeek = []; //index 0-4 means weekly revenues on 1st month of 2016
for (var i = 0; i < 300; i++) {
    revenueWeek.push(0);
}
var sedanStock, coupeStock, suvStock, pickupStock, sportscarStock;
sedanStock = coupeStock = suvStock = pickupStock = sportscarStock = 200;
var topSell1, topSell2, topSell3;
var intTopSell1, intTopSell2, intTopSell3;
var monthTemp = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Des'];
var tempColor = ['color: #009E73', 'color: #F0E442', 'color: #0072B2', 'color: #D55E00', 'color: #CC79A7'];
var topSell1Category, topSell2Category, topSell3Category;


fetch('asset/Data Mentah 2.csv')
    .then(response => response.text())
    .then(data => process(data));
function process(data) {
    var temp = data.split("\n");
    for (var i = 0; i < temp.length; i++) {
        dataset1.push(temp[i].split(","));
    }

    // revenue by year/month/week
    // product availability
    // revenue comparison
    for (var i = 0; i < dataset1.length; i++) {
        if (dataset1[i][0] == "Sedan") sedanStock--; //jika model == sedan, maka stok sedan kurangi 1
        else if (dataset1[i][0] == "Coupe") coupeStock--; //jika model == coupe, maka stok coupe kurangi 1
        else if (dataset1[i][0] == "SUV") suvStock--; //jika model == suv, maka stok suv kurangi 1
        else if (dataset1[i][0] == "Pickup") pickupStock--; //jika model == pickup, maka stok pickup kurangi 1
        else if (dataset1[i][0] == "Sports car") sportscarStock--; //jika model == sports car, maka stok sports car kurangi 1

        if (dataset1[i][6] == 2016) { //jika tahun == 2016
            var temp = parseInt(dataset1[i][2]); // harga current selected transaction disimpan ke temp
            revenueYear[0] += temp; //revenue tahun 2016 ditambahkan dengan temp
            revenueMonth[dataset1[i][5] - 1] += temp; //revenueMonth ditambahkan sesuai bulannya (month pada thn 2016 ada di index 0-11)

            if (temp != 0) {
                monthlyRevenue[dataset1[i][5] - 1] += temp;
                monthlyRevenueCount[dataset1[i][5] - 1]++;
            }
            var temp1 = parseInt(dataset1[i][4]); // temp1 menyimpan tanggal current selected transaction(1-30)
            if (Math.ceil(temp1 / 7) == 1) { // jika minggu pertama
                revenueWeek[(Math.ceil(temp1 / 7) + 4) * dataset1[i][5] - 5] += temp; // revenue minggu pertama ditambahkan dengan temp
            }
            else if (Math.ceil(temp1 / 7) == 2) { // jika minggu kedua
                revenueWeek[(Math.ceil(temp1 / 7) + 3) * dataset1[i][5] - 4] += temp; // revenue minggu kedua ditambahkan dengan temp
            }
            else if (Math.ceil(temp1 / 7) == 3) { // jika minggu ketiga
                revenueWeek[(Math.ceil(temp1 / 7) + 2) * dataset1[i][5] - 3] += temp; // revenue minggu ketiga ditambahkan dengan temp
            }
            else if (Math.ceil(temp1 / 7) == 4) { // jika minggu keempat
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 2] += temp; // revenue minggu keempat ditambahkan dengan temp
            }
            else if (Math.ceil(temp1 / 7) == 5) { // jika minggu kelima
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 1] += temp; // revenue minggu kelima ditambahkan dengan temp
            }
        }
        else if (dataset1[i][6] == 2017) {
            var temp = parseInt(dataset1[i][2]);
            revenueYear[1] += temp;
            revenueMonth[dataset1[i][5] - 1 + 12] += temp;
            if (temp != 0) {
                monthlyRevenue[dataset1[i][5] - 1 + 12] += temp;
                monthlyRevenueCount[dataset1[i][5] - 1 + 12]++;
            }

            var temp1 = parseInt(dataset1[i][4]);
            if (Math.ceil(temp1 / 7) == 1) {
                revenueWeek[(Math.ceil(temp1 / 7) + 4) * dataset1[i][5] - 5 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 2) {
                revenueWeek[(Math.ceil(temp1 / 7) + 3) * dataset1[i][5] - 4 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 3) {
                revenueWeek[(Math.ceil(temp1 / 7) + 2) * dataset1[i][5] - 3 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 4) {
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 2 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 5) {
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 1 + 60] += temp;
            }
        }
        else if (dataset1[i][6] == 2018) {
            var temp = parseInt(dataset1[i][2]);
            revenueYear[2] += temp;
            revenueMonth[dataset1[i][5] - 1 + 12 + 12] += temp;
            if (temp != 0) {
                monthlyRevenue[dataset1[i][5] - 1 + 12 + 12] += temp;
                monthlyRevenueCount[dataset1[i][5] - 1 + 12 + 12]++;
            }

            var temp1 = parseInt(dataset1[i][4]);
            if (Math.ceil(temp1 / 7) == 1) {
                revenueWeek[(Math.ceil(temp1 / 7) + 4) * dataset1[i][5] - 5 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 2) {
                revenueWeek[(Math.ceil(temp1 / 7) + 3) * dataset1[i][5] - 4 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 3) {
                revenueWeek[(Math.ceil(temp1 / 7) + 2) * dataset1[i][5] - 3 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 4) {
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 2 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 5) {
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 1 + 60 + 60] += temp;
            }
        }
        else if (dataset1[i][6] == 2019) {
            var temp = parseInt(dataset1[i][2]);
            revenueYear[3] += temp;
            revenueMonth[dataset1[i][5] - 1 + 12 + 12 + 12] += temp;
            if (temp != 0) {
                monthlyRevenue[dataset1[i][5] - 1 + 12 + 12 + 12] += temp;
                monthlyRevenueCount[dataset1[i][5] - 1 + 12 + 12 + 12]++;
            }

            var temp1 = parseInt(dataset1[i][4]);
            if (Math.ceil(temp1 / 7) == 1) {
                revenueWeek[(Math.ceil(temp1 / 7) + 4) * dataset1[i][5] - 5 + 60 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 2) {
                revenueWeek[(Math.ceil(temp1 / 7) + 3) * dataset1[i][5] - 4 + 60 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 3) {
                revenueWeek[(Math.ceil(temp1 / 7) + 2) * dataset1[i][5] - 3 + 60 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 4) {
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 2 + 60 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 5) {
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 1 + 60 + 60 + 60] += temp;
            }
        }
        else if (dataset1[i][6] == 2020) {
            var temp = parseInt(dataset1[i][2]);
            revenueYear[4] += temp;
            revenueMonth[dataset1[i][5] - 1 + 12 + 12 + 12 + 12] += temp;
            if (temp != 0) {
                monthlyRevenue[dataset1[i][5] - 1 + 12 + 12 + 12 + 12] += temp;
                monthlyRevenueCount[dataset1[i][5] - 1 + 12 + 12 + 12 + 12]++;
            }

            var temp1 = parseInt(dataset1[i][4]);
            if (Math.ceil(temp1 / 7) == 1) {
                revenueWeek[(Math.ceil(temp1 / 7) + 4) * dataset1[i][5] - 5 + 60 + 60 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 2) {
                revenueWeek[(Math.ceil(temp1 / 7) + 3) * dataset1[i][5] - 4 + 60 + 60 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 3) {
                revenueWeek[(Math.ceil(temp1 / 7) + 2) * dataset1[i][5] - 3 + 60 + 60 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 4) {
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 2 + 60 + 60 + 60 + 60] += temp;
            }
            else if (Math.ceil(temp1 / 7) == 5) {
                revenueWeek[(Math.ceil(temp1 / 7) + 1) * dataset1[i][5] - 1 + 60 + 60 + 60 + 60] += temp;
            }
        }

    }

    // top selling product
    var tempSell = 50; //stok awal per model
    var tempSellLoc = 0; //lokasi array untuk current model yang top selling
    topSell1 = topSell2 = topSell3 = "";
    for (var i = 1; i < dataset1.length; i++) {
        if (tempSell >= parseInt(dataset1[i][3])) { //jika stok lebih besar dari current stok, maka yang topselling adalah current stock
            tempSell = dataset1[i][3];
            tempSellLoc = i; //lokasi topselling disimpen
        }
    }
    topSell1 = dataset1[tempSellLoc][1];
    topSell1Category = dataset1[tempSellLoc][0];
    intTopSell1 = tempSell;

    tempSell = 50;
    tempSellLoc = 0;
    for (var i = 1; i < dataset1.length; i++) {
        if (tempSell >= parseInt(dataset1[i][3])) {
            if (dataset1[i][1] == topSell1) {

            }
            else {
                tempSell = dataset1[i][3];
                tempSellLoc = i;
            }
        }
    }
    topSell2 = dataset1[tempSellLoc][1];
    topSell2Category = dataset1[tempSellLoc][0];
    intTopSell2 = tempSell;

    tempSell = 50;
    tempSellLoc = 0;
    for (var i = 1; i < dataset1.length; i++) {
        if (tempSell >= parseInt(dataset1[i][3])) {
            if (dataset1[i][1] == topSell1 || dataset1[i][1] == topSell2) {

            }
            else {
                tempSell = dataset1[i][3];
                tempSellLoc = i;
            }
        }
    }
    topSell3 = dataset1[tempSellLoc][1];
    topSell3Category = dataset1[tempSellLoc][0];
    intTopSell3 = tempSell;

    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }

    // total revenue
    var totalRevenue = revenueYear.reduce((a, b) => a + b, 0);
    var totalPreviousRevenue = totalRevenue - revenueYear[4];
    document.getElementById("totalrevv").innerHTML += numberWithCommas(totalRevenue);
    document.getElementById("totalrevv").style.fontSize = '70px';
    document.getElementById("totalrevv").style.color = 'white';

    document.getElementById("previous").innerHTML += 'Previous';
    document.getElementById("previous2").innerHTML += numberWithCommas(totalPreviousRevenue);

    document.getElementById("change").innerHTML += 'Change';
    if (totalRevenue > totalPreviousRevenue) {
        var trendtemp = parseFloat(((parseFloat(totalRevenue).toFixed(2) / parseFloat(totalPreviousRevenue).toFixed(2)) - 1) * 100).toFixed(2);
        document.getElementById("change2").innerHTML += '+';
        document.getElementById("change2").innerHTML += trendtemp;
        document.getElementById("change2").innerHTML += '%';
        document.getElementById("change2").style.color = 'green';

    }
    else if (totalRevenue < totalPreviousRevenue) {
        var trendtemp = parseFloat((1 - (parseFloat(totalRevenue).toFixed(2) / parseFloat(totalPreviousRevenue).toFixed(2))) * 100).toFixed(2);
        document.getElementById("change2").innerHTML += '-';
        document.getElementById("change2").innerHTML += trendtemp;
        document.getElementById("change2").innerHTML += '%';
        document.getElementById("change2").style.color = 'red';
    }

    document.getElementById("trend").innerHTML += 'Trend';
    if (totalRevenue > totalPreviousRevenue) {
        document.getElementById("trend2").innerHTML += '<span style="color: green">&#9650</span>';

    }
    else if (totalRevenue < totalPreviousRevenue) {
        document.getElementById("trend2").innerHTML += '<span style="color: red">&#9660</span>';
        // document.getElementById("trend").style.color = "red";
        console.log(revenueMonth);
    }

}