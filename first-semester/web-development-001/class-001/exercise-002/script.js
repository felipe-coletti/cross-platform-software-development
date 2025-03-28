function validateForm() {
    let cpf = document.getElementById("cpf").value 
    let password = document.getElementById("password").value
    let confirmPassword = document.getElementById("confirm-password").value

    if (cpf.length != 11) {
        alert("CPF inválido.")
        register.cpf.focus()
    }
    if (isNaN(cpf)) {
        alert("Informe apenas números para o campo CPF.")
        register.cpf.focus()
    }
    if (confirmPassword != password) {
        alert("Senhas não conferem.")
        register.confirmPassword.focus()
    }

    const regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\w\s]).{6,10}$/

    if (!regex.exec(password)) {
        alert("A senha deve conter no mínimo uma letra maiúscula, uma letra minúscula, um número, um caractere especial, mínimo 6 e máximo 10 caracteres.")
        register.password.focus()
    }
}
