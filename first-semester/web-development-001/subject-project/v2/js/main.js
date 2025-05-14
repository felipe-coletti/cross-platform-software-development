import { setupDropdown } from './dropdown.js'
import { setupMenu } from './menu.js'
import { setupMobileMenu } from './hamburgerMenu.js'

const init = () => {
	setupDropdown()
	setupMenu()
	setupMobileMenu()
}

document.addEventListener('DOMContentLoaded', init)
