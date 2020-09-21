import { Component, OnInit, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.sass']
})

export class ProductsComponent implements OnInit {

  readonly API_ENDPOINT = "http://localhost:8080/api/products";

  @Output() products = []

  // HTMLElement of modal to manipulate
  productBuyModal = window.document.querySelector("app-product-buy");

  constructor( private http: HttpClient ) { 
    this.http.get( this.API_ENDPOINT ).toPromise().then( productsGetteds => {
      productsGetteds.forEach( product => {
        console.log(product)
      this.products.push( product )}
      )
    } )
   }

  // Show modal to buy a product
  buyProductShowModal( $event ){
    let product_id = $event.target.getAttribute("id")
    this.productBuyModal.classList.add("app-product-buy")
    this.productBuyModal.classList.remove("product-buy-modal-dialog-hidden")
    this.productBuyModal.setAttribute("product-id", product_id)
  }

  // -------- Utils functions --------

  // Close modal if is showing
  utilCloseModal(){
    document.querySelector(".product-buy-modal-backdrop").remove()
    document.querySelector(".product-buy-modal").remove()
    this.productBuyModal.removeAttribute("product-id")
  }

  // Used to instanciate an image on view
  utilGetSrc( product ){
      return "url('" + product.productView.httpProtocol + "://" + product.productView.host + ":" + product.productView.port + "/" +  product.productView.imgSrcFolder + "/" + product.imgFile + "')";
  }

  // Used to get an id from product based on element position
  getProductById( id ){
    return this.products[id];
  }
    // ------------------------------

  ngOnInit() { }

}
