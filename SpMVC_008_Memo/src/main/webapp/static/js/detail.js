const memo = document.querySelector(".memo");

memo.addEventListener("click", (e) => {
  const target = e.target.closest(".m_content");
  console.log(target.dataset.id);
  location.href = `${rootPath}/detail?id=${target.dataset.id}`;
});
