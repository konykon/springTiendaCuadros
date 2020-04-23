function fetchJson(url) {
    return fetch(url, {
        method: 'GET',
        credentials: 'include'
    }).then(function (response) {
        if (response.ok) {
            return response.json();
        }
        throw new Error(response.statusText);
    });
}

$(document).ready(function () {
    fetchJson('http://localhost:8080/shops')
        .then(function (data) {
            fillTable(data);
            console.log(data);
        })
});

function addCell(tr, val) {
    let td = document.createElement('td');
    td.innerHTML = val;
    tr.appendChild(td);
}

function addRow(table, val_1, val_2, val_3) {
    let tr = document.createElement('tr');
    addCell(tr, val_1);
    addCell(tr, val_2);
    addCell(tr, val_3);
    table.appendChild(tr);
}

function fillTable(data) {
    let table = document.getElementById('tableShops');
    data.forEach(tienda => {
        addRow(table, tienda.id, tienda.name, tienda.capacity);
    });
}

function createShop() {
    let url = 'http://localhost:8080/shops';
    let name = document.getElementById('shop').value;
    let capacity = document.getElementById('capacity').value;
    const shop = {
        name: name,
        capacity: capacity
    };
    $.ajax({
        type: 'POST',
        url: url,
        data: JSON.stringify(shop),
        headers: { 'Content-Type': 'application/json' },
        success: function (data) {
            console.log(data);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function createPicture() {
    let nameOfShop = document.getElementById('nameOfShop').value;
    let name = document.getElementById('picture').value;
    let author = document.getElementById('author').value;
    fetchJson('http://localhost:8080/shops')
        .then(function (data) {
            data.forEach(shop => {
                if (nameOfShop == shop.name) {
                    let id = shop.id;
                    const picture = {
                        name: name,
                        author: author,
                        shop_id: id
                    };
                    $.ajax({
                        type: 'POST',
                        url: 'http://localhost:8080/shops/' + id + '/pictures',
                        data: JSON.stringify(picture),
                        headers: { 'Content-Type': 'application/json' },
                        success: function (data) {
                            shop.pictures = data;
                            console.log(data);
                        },
                        error: function (error) {
                            console.log(error);
                        }
                    });
                }
            });
        });
}

function showPictures() {
    let nameOfShop = document.getElementById('nameShop').value;
    let table = document.getElementById('tablePictures');
    table.innerHTML = "";
    fetchJson('http://localhost:8080/shops')
        .then(function (data) {
            data.forEach(shop => {
                if (nameOfShop == shop.name) {
                    let id = shop.id;
                    fetchJson('http://localhost:8080/shops/' + id + '/pictures')
                        .then(function (data) {
                            data.forEach(picture => {
                                addRow(table, picture.id, picture.name, picture.author);
                            });
                        });
                }
            });
        });

}

function deletePicture() {
    let nameOfShop = document.getElementById('shopName').value;
    let pictureName = document.getElementById('pictureToDelete').value;
    fetchJson('http://localhost:8080/shops')
        .then(function (data) {
            data.forEach(shop => {
                if (nameOfShop == shop.name) {
                    let shop_id = shop.id;
                    fetchJson('http://localhost:8080/shops/' + shop_id + '/pictures')
                        .then(function (data) {
                            data.forEach(picture => {
                                if (pictureName == picture.name) {
                                    let id = picture.id;
                                    $.ajax({
                                        type: 'DELETE',
                                        url: 'http://localhost:8080/shops/' + shop_id + '/pictures/' + id,
                                        headers: { 'Content-Type': 'application/json' },
                                        success: function () {
                                            document.getElementById("msgDel").innerHTML = `El cuadro esta eliminado.`;
                                        },
                                        error: function (error) {
                                            console.log(error);
                                        }
                                    });
                                }
                            });
                        });
                }
            });
        });
}

