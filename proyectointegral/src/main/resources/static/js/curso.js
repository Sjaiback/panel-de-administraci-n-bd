(function(){
//alert("hola mundo");
var listaBotonesEditar = document.querySelectorAll(".editarCurso");
listaBotonesEditar.forEach(item =>{
    item.addEventListener("click", e =>{
        document.getElementById('id').value = item.dataset.id;
        document.getElementById('cboCategoria').value = item.dataset.categoria;
        document.getElementById('txtNombre').value = item.dataset.nombre;
        document.getElementById('txtCreditos').value = item.dataset.creditos;
        document.getElementById('txtCosto').value = item.dataset.costo;
        new bootstrap.Modal(document.getElementById('modalEditar')).show();
        e.preventDefault();
    },false)
})
})();