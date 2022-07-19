const PRODUCT_ENDPOINT = 'product';
const BUCKET_ENDPOINT = 'bucket';

const createCard = (product) =>
    `
                <div class="col">
                    <div class="card shadow-sm">
                        <img src="http://localhost:8080/ProjectServlets_war_exploded/images/product_img.png" alt="product">
                        <div class="card-body">
                            <h3>${product.name}</h3>
                            <p class="card-text">${product.description}</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <a href="product?id=${product.id}">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                    </a>
                                    <button id="${product.id}" type="button" class="btn btn-sm btn-outline-success">
                                        <i class="fa-solid fa-basket-shopping"></i>
                                    </button>
                                </div>
                                <span class="text-muted">${product.price} $</span>
                            </div>
                        </div>
                    </div>
                </div>`;

function addProductToBucket(productId) {
    console.log('!!!!!');
    fetch(BUCKET_ENDPOINT, {
        headers:{
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify({productId})
    }).then((result) => {
        console.log(result);
        alert('Added to bucket');
    })
}

function getProducts() {
    const sendRequest = async () => {
        const result = await fetch(PRODUCT_ENDPOINT, {
            method: 'GET',
            'Content-Type': 'application/json'
        });
        let products = await result.json();

        console.log(products);

        const element = document.querySelector('#content');
        products.forEach((item) => {
            element.innerHTML = element.innerHTML + createCard(item);

        });
        products.forEach((item) => {
            document.querySelector(`#${item.id}`).addEventListener('click',()=>{
                addProductToBucket(item.id)
            })
        });




    }
    sendRequest();
}

getProducts();


