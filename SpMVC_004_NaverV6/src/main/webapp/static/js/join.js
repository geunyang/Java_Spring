document.addEventListener("DOMContentLoaded", () => {
  const username = document.querySelector("#username");
  const password = document.querySelector("#password");
  const re_password = document.querySelector("#re_password");
  const email = document.querySelector("#email");
  const btn_join = document.querySelector("#btn-join");

  const div_index = {
    username: 0,
    password: 1,
    re_password: 2,
    email: 3,
    name: 4,
    nickname: 5,
  };
  const error_divs = document.querySelectorAll("div.error");

  // 특문영문포함 8~15
  const passRule2 =
    /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

  // 숫자를 포함하는 6자리 ~ 12자리의 문자열 검사 패턴
  const passRule = /^[A-Za-z0-9]{6,12}$/;

  //메일형식검사
  const emailRule =
    /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

  // 화면이 모두 그려지면 username input box 에 포커싱 하기
  username?.focus();

  const error_msg = (div, message) => {
    div.classList.remove("w3-text-blue");
    div.classList.add("w3-text-red");
    div.innerText = message;
  };

  const ok_msg = (div, message) => {
    div.classList.remove("w3-text-red");
    div.classList.add("w3-text-blue");
    div.innerText = message;
  };

  /*
  input box 에서 focus 가 벗어났을 때 발생하는 event
  focusout, blur
  focusout 은 이벤트 버블링이 심하게 발생
  JS 코드에서는 주로 blur 를 사용
  */
  username?.addEventListener("blur", (e) => {
    const current = e.currentTarget;
    const username_div = error_divs[div_index.username];

    if (current.value === "") {
      const msg = "USER NAME 은 반드시 입력하세요";

      error_msg(username_div, msg);

      current.focus();
      return false;
    }

    // 중복검사를 수행
    fetch(`${rootPath}/user/idcheck/${current.value}`)
      .then((res) => res.text())
      .then((result) => {
        // 서버에서 OK 문자열을 보내면 체크한 username 은 사용해도 된다
        if (result === "OK") {
          const msg = "사용가능한 USER NAME 입니다";
          ok_msg(username_div, msg);
        } else {
          error_msg(username_div, "이미 가입된 USER NAME 입니다");
          username.focus();
        }
      });
  }); //end username event

  password?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const error = error_divs[div_index.password];
    if (passRule2.test(current.value)) {
      ok_msg(error, "비밀번호 설정 완료");
    } else {
      error_msg(
        error,
        "비밀번호가 규칙에 맞지 않습니다(특수, 영문, 숫자 포함 8~15자로 작성)"
      );
    }
  });

  re_password?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const error = error_divs[div_index.re_password];

    if (current.value === password?.value) {
      ok_msg(error, "비밀번호가 일치합니다");
    } else {
      error_msg(error, "비밀번호가 일치하지 않습니다");
    }
  }); // end password event

  email?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const error = error_divs[div_index.email];
    if (emailRule.test(current.value)) {
      ok_msg(error, "Email 양식 검사 완료");
    } else {
      error_msg(error, "Email 양식을 확인해주세요");
      // 양식검사 통과 못하면 다음 코드 실행되지 않도록
      return false;
    } // 양식검사 end

    fetch(`${rootPath}/user/emailcheck?email=${current.value}`)
      .then((res) => res.text())
      .then((result) => {
        if (result === "OK") {
          ok_msg(error, "사용할 수 있는 Email 입니다");
        } else {
          error_msg(error, "이미 등록된 Email 입니다");
          current.focus();
        }
      });
  });

  btn_join?.addEventListener("click", () => {
    if (username.value === "") {
      alert("USER NAME 은 반드시 입력하세요");

      username.focus();
      return false;
    }
    if (username.value.length > 20) {
      alert("USER NAME 은 20자 이내로 입력하세요");
      username.focus();
      return false;
    }
    if (username.value.toUpperCase() === password.value.toUpperCase()) {
      alert("USER NAME 과 비밀번호는 같을 수 없습니다");
      password.focus();
      return false;
    }

    // password.value 의 값이 패턴에 일치하지 않으면
    if (passRule2.test(password.value) === false) {
      alert("비밀번호는 문자, 숫자, 포함 6자리 ~ 12자리까지 입력하세요");
      password.focus();
      return false;
    }

    if (re_password.value === "") {
      alert("비밀번호 확인을 입력해주세요");
      re_password.focus();
      return false;
    }

    if (password.value !== re_password.value) {
      alert("비밀번호 확인 값이 일치하지 않습니다");
      password.value = "";
      re_password.value = "";
      password.focus();
      return false;
    }

    if (!emailRule.test(email.value)) {
      alert("이메일 형식이 잘못되었습니다 다시 입력해주세요");
      email.focus();
      return false;
    }
    document.querySelector("form.join")?.submit();
  });
});
