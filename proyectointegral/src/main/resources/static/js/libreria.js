const botonMenu = document.body.querySelector("#menuToggle");

botonMenu.addEventListener("click", event =>{
    //alert("Hiciste click en el boton");
    document.body.classList.toggle("sb-sidenav-toggled");
})