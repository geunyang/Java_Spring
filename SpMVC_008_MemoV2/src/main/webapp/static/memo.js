document.addEventListener("DOMContentLoaded", () => {
  const memo_table = document.querySelector("table.memo");
  memo_table?.addEventListener("click", (e) => {
    // table 에 click 이벤트를 적용하면 가장 안쪽의 td 가 target 으로 작동한다
    const target = e.target;
    // 가장 안쪽의 td 가 클릭되면
    // td 를 감싸고 있는 tr 을 찾아라
    const tr = target?.closest("TR");

    const seq = tr?.dataset.seq;
    /*
    JS 에서 변수값이 
    0, undefined, null, NaN, "" 등은 if 에서 모두 false 로 인식
    seq 값이 정상적인 범위의 값일 경우에만 detail 로 이동하는 코드
    */
    if (seq) {
      document.location.href = `${rootPath}/memo/${seq}/detail`;
    }
  });
});
