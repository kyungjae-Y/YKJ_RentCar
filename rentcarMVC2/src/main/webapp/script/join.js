let check = 0;

function validCheck(form) {
	if (!form.id.value.trim()) {
		alert("아이디를 입력해주세요");
		form.id.focus();
		return false;
	}
	if (!form.pw.value.trim()) {
		alert("비밀번호를 입력해주세요");
		form.pw.focus();
		return false;
	}
	if (!form.email.value.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)) {
		alert("이메일 형식이 다릅니다");
		form.email.value = "test@test.com";
		form.email.focus();
		return false;
	}
	if (!form.tel.value.match(/010-\d{3,4}-\d{4}/)) {
		alert("전화번호 형식이 다릅니다");
		form.tel.value = "010-1111-1111";
		form.tel.focus();
		return false;
	}
	if (!form.hobby.value.trim()) {
		alert("취미를 입력해주세요");
		form.hobby.focus();
		return false;
	}
	if (!form.job.value.trim()) {
		alert("직업을 입력해주세요");
		form.job.focus();
		return false;
	}
	if (!form.age.value.trim()) {
		alert("나이를 입력해주세요");
		form.age.focus();
		return false;
	} else {
		if (Number(form.age.value.trim()) < 20) {
			alert("20살 밑으로는 가입할 수 없습니다");
			form.age.focus();
			return false;
		}
	}
	if (!form.info.value.trim()) {
		alert("소개를 입력해주세요");
		form.info.focus();
		return false;
	}
	if (check == 0) {
		alert("ID 중복체크 해주세요");
		return false;
	} else if (check == -1) {
		alert("ID 중복체크 다시 해주세요");
		return false;
	}
	form.submit();
}

document.getElementById("checkId").addEventListener("click", () => {
	let id = document.getElementById("id").value.trim();
	if (id.length === 0) {
		alert("ID 값을 입력해주세요");
		document.getElementById("id").focus();
		document.getElementById("id").style.border = "";
		return;
	}
	fetch("validateId.do", {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
		},
		body: "id=" + id,
	})
		.then(response => response.text())
		.then(getResult)
		.catch(() => alert("error"));
})

function getResult(data) {
	if (data === "valid") {
		alert("사용 가능한 아이디 입니다");
		document.getElementById("pw").focus();
		document.getElementById("id").style.border = "3px blue solid";
		check = 1;
	} else if (data === "notValid") {
		alert("사용 불가능한 아이디 입니다");
		document.getElementById("id").value = "";
		document.getElementById("id").focus();
		document.getElementById("id").style.border = "3px red solid";
		check = -1;
	}
}

document.getElementById("id").addEventListener("keyup", (e) => {
	if (e.keyCode === 8) {
		check = 0;
	}
	document.getElementById("id").style.border = "";
});