import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewEncapsulation, ViewChild } from '@angular/core';

@Component({
  selector: 'app-product-buy',
  templateUrl: './product-buy.component.html',
  styleUrls: ['./product-buy.component.sass'],
  encapsulation: ViewEncapsulation.None
})

export class ProductBuyComponent implements OnInit {

  readonly API_ENDPOINT = "http://localhost:8080/api/user/purchase";

  constructor( private http: HttpClient) { }

  @ViewChild('email_input') emailInput;  
  
    // Accept buying a product
    buyProduct(){
      // Necesary vars
      let emailElement = this.emailInput.nativeElement;
      let emailValue = emailElement.value;
      let appProductElement = document.querySelector("app-product-buy");
      let product_id = parseInt(appProductElement.getAttribute("product-id"))

      // Verify if product id and email is correctly formed
      if( !isNaN(product_id) && product_id > 0 ){
        if( emailElement.value != '' && emailValue.match(/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/) ){

          // Encapsule values on FormData to send
          var formData = new FormData();
          formData.append("email", emailValue);
          formData.append("product_id", String(product_id));

          // Save product on API
          this.saveProduct( formData ).then( added => {
            alert("Se ha agregado el producto al usuario correctamente.")
            this.utilCloseModal()
          })
        }else{
          alert("Está intentando introducir una dirección de correo inválida.")
        }
      }else{
        alert("Debe elegir un producto registrado.")
      }
    }
  
    //Save product API CallBack
    saveProduct( formData ){
      return this.http.post( this.API_ENDPOINT, formData ).toPromise()
    }

    // Cancel buying a product
    cancelBuyProduct(){
      this.utilCloseModal()
    }

    // close modal
    utilCloseModal(){
      let appProductElement = document.querySelector("app-product-buy");
      appProductElement.classList.remove("app-product-buy")
      appProductElement.classList.add("product-buy-modal-dialog-hidden")
      appProductElement.removeAttribute("product_id")
    }
  ngOnInit() { }

}
