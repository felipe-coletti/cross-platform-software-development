const openMenuButton = document.getElementById('menu-button')
const menuBackdrop = document.getElementById('mobile-menu')

const toggleMobileMenu = () => {
	const isOpen = menuBackdrop.classList.contains('show')

	menuBackdrop.classList.toggle('show', !isOpen)

	openMenuButton.setAttribute('aria-expanded', String(!isOpen))
	menuBackdrop.setAttribute('aria-hidden', String(isOpen))
}

export const setupMobileMenu = () => {
	openMenuButton.addEventListener('click', toggleMobileMenu)
	menuBackdrop.addEventListener('click', e => {
		if (e.target === e.currentTarget) {
			toggleMobileMenu()
		}
	})
}
