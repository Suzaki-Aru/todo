//const select = document.getElementById('sort');
//select.addEventListener('change', (e) => {
//  const selectValue = document.getElementById('sort');
//  selectValue.innerHTML = e.target.value;
//});

//let button = document.getElementsByClassName('detailBtn');
//document.getElementById('sortValue').value = document.getElementById('sort').value

let select = document.getElementById('sort');
let sortValue = document.getElementById('sortValue').value - 1;
select.options[sortValue].selected = true;