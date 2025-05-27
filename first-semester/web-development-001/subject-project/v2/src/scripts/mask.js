document.addEventListener('DOMContentLoaded', () => {
	const cpfInput = document.getElementById('cpf')
	const phoneNumberInput = document.getElementById('phone-number')
	const zipCodeInput = document.getElementById('zip-code')

	function maskCPF(value) {
		return value
			.replace(/\D/g, '')
			.replace(/(\d{3})(\d)/, '$1.$2')
			.replace(/(\d{3})(\d)/, '$1.$2')
			.replace(/(\d{3})(\d{1,2})$/, '$1-$2')
	}

	function maskPhoneNumber(value) {
		return value
			.replace(/\D/g, '')
			.replace(/^(\d{2})(\d)/g, '($1) $2')
			.replace(/(\d{5})(\d)/, '$1-$2')
	}

	function maskZipCode(value) {
		return value.replace(/\D/g, '').replace(/(\d{5})(\d)/, '$1-$2')
	}

	cpfInput.addEventListener('input', e => {
		e.target.value = maskCPF(e.target.value)
	})

	phoneNumberInput.addEventListener('input', e => {
		e.target.value = maskPhoneNumber(e.target.value)
	})

	zipCodeInput.addEventListener('input', e => {
		e.target.value = maskZipCode(e.target.value)
	})
})
