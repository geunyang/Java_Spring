document.addEventListener("DOMContentLoaded", () => {
  const table = document.querySelector("TABLE");

  // 현재 DOM 화면에 있는 모든 TD 들을 가져와서
  // 모든 TD 들에게 click event를 부착하기
  // 코드 개수가 많아지면 비효율적
  //   const tds = document.querySelectorAll("TD");

  //   for (let i = 0; i < tds.length; i++) {
  //     tds[i].addEventListener("click", () => {
  //       alert(tds[i].innerText);
  //     });
  //   }

  /* 
      이 스크립트가 실행되는 DOM 화면에 table tag가 있으면
      if(){} 코드를 실행하고 없으면 건너 뛰어라
  
      만약 이 스크립트가 실행되는 DOM 화면에 table tag가 없으면
      변수 table 에는 undefined가 담기게 된다
      그러면 if() 조건문에서 false가 발생한다.
      */
  if (table) {
    table.addEventListener("click", (e) => {
      const target = e.target;
      const text = target.innerText;
      const className = target.className;
      const stNum = target.dataset.num;
      if (className === "name") {
        // 문자열 template 설정
        // 문자열 내에 변수를 직접 적용하는 문법
        document.location.href = `${rootPath}/student/detail?stNum=${stNum}`;
      }
    });
  }
});
