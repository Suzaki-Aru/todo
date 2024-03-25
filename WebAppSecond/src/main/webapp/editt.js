const select = document.getElementById('priority');
select.addEventListener('change', (e) => {
  const selectValue = document.getElementById('priority');
  selectValue.innerHTML = e.target.value;
});