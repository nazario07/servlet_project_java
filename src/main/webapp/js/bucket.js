const BUCKET_ENDPOINT = 'bucket';
const defaultImg = 'http://localhost:8080/ProjectServlets_war_exploded/images/product_img.png';

const createListItem = (item) =>
    `
    <div class="bucket-item">
        <div class="image">
            <img width="150" height="150"
             src="${item.image ? item.image : defaultImg}" alt="product_in_bucket" 
             alt="product">
        </div>

        <div class="content">
            <h3>${item.name}</h3>
            <p>
                ${item.description}
            </p>
            <div>
            ${item.price} $
            </div>
        </div>

        <div class="btns">
            <button onclick="removeItem(${item.id})" class="btn btn-danger">Remove</button>
        
        </div>
        
    </div>
    `



function removeItem(id) {
    fetch(`${BUCKET_ENDPOINT}?productId=${id}`, {
        method: 'DELETE',
    }).then(() => {
        window.location.reload();
    });
}

function getItems() {
    const bucketContainer = document.getElementById("bucket");
    fetch(BUCKET_ENDPOINT, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then((result) => {
        console.log('result', result);
        return result.json();
    }).then((json) => {
        json.forEach((item) => {
            bucketContainer.innerHTML += createListItem(item);
        })

    })
}

getItems();