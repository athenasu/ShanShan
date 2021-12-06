$(function(){
    /* -----------店家註冊營登證上傳---------- */
      var ceti = document.getElementById("ceti");
      ceti.addEventListener("change",function(e){
        console.log("change");
        console.log(this);
        console.log(this.files);
        console.log(this.files[0]);
      var cetiPhoto = document.getElementsByClassName("cetiPhoto")[0];
      cetiPhoto.innerHTML = "";

        let reader = new FileReader();
        reader.readAsDataURL(this.files[0]);
        reader.addEventListener("load",function(){
          console.log(reader.result);
          let li_html =`<li><img src="${reader.result}" class="cetiBanner"></li>`;
          cetiPhoto.insertAdjacentHTML("beforeend",li_html);
        });
      })
    /* -----------店家註冊營登證結束---------- */
    
    
      })

    
   
