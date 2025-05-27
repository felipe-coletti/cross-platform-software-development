document.addEventListener('DOMContentLoaded', () => {
	const zipCodeInput = document.getElementById('zip-code')
	const streetInput = document.getElementById('street')
	const neighborhoodInput = document.getElementById('neighborhood')
	const cityInput = document.getElementById('city')
	const ufInput = document.getElementById('uf')

	function clearZipCodeForm() {
		streetInput.value = ''
		neighborhoodInput.value = ''
		cityInput.value = ''
		ufInput.value = ''
	}

	zipCodeInput.addEventListener('blur', async () => {
		const zipCode = zipCodeInput.value.replace(/\D/g, '')

		if (zipCode !== '') {
			const validateZipCode = /^[0-9]{8}$/

			if (validateZipCode.test(zipCode)) {
				streetInput.value = 'Carregando...'
				neighborhoodInput.value = 'Carregando...'
				cityInput.value = 'Carregando...'
				ufInput.value = 'Carregando...'

				try {
					const response = await fetch(`https://viacep.com.br/ws/${zipCode}/json/`)
					const data = await response.json()

					if (!data.erro) {
						streetInput.value = data.logradouro || ''
						neighborhoodInput.value = data.bairro || ''
						cityInput.value = data.localidade || ''
						ufInput.value = data.uf || ''
					} else {
						clearZipCodeForm()
						alert('CEP não encontrado.')
					}
				} catch (error) {
					clearZipCodeForm()
					alert('Erro ao buscar CEP.')
				}
			} else {
				clearZipCodeForm()
				alert('Formato de CEP inválido.')
			}
		} else {
			clearZipCodeForm()
		}
	})
})
