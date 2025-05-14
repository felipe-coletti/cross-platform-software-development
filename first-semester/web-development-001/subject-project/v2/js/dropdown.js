export const setupDropdown = () => {
	document.querySelectorAll('.dropdown-label').forEach(item => {
		item.addEventListener('click', function (e) {
			e.preventDefault()
			const parent = this.closest('.dropdown')

			parent.classList.toggle('active')

			document.querySelectorAll('.dropdown').forEach(dropdown => {
				if (dropdown !== parent) {
					dropdown.classList.remove('active')
				}
			})
		})
	})
}
