class FatecNav extends HTMLElement {
	constructor() {
		super()

		this.attachShadow({ mode: 'open' })

		this.shadowRoot.innerHTML = `
			<link rel="stylesheet" href="src/styles/global.css" />
			<link rel="stylesheet" href="src/styles/nav.css" />
			<nav id="nav-bar">
				<div class="container">
					<ul id="menu" class="list">
						<li><a class="menu-item" href="index.html">Início</a></li>
						<li><a class="menu-item" href="comments.html">Comentários</a></li>
						<li><a class="menu-item" href="metadata.html">Metadados</a></li>
						<li class="dropdown">
							<a class="dropdown-label menu-item" href="javascript:void(0);">Listas</a>
							<ul class="dropdown-menu list">
								<li><a class="dropdown-item" href="ol.html">Lista Ordenada</a></li>
								<li><a class="dropdown-item" href="ul.html">Lista Não Ordenada</a></li>
							</ul>
						</li>
						<li><a class="menu-item" href="layout.html">Layout</a></li>
						<li><a class="menu-item" href="contact.html">Fale Conosco</a></li>
					</ul>
					<h3 class="tertiary-title title mobile">Fatec Ourinhos Clone</h3>
					<button id="menu-button" class="mobile" aria-expanded="false">
						<span id="menu-button-line"></span>
					</button>
				</div>
				<ul id="mobile-menu" class="list mobile" aria-hidden="true">
					<li><a class="menu-item" href="index.html">Início</a></li>
					<li><a class="menu-item" href="comments.html">Comentários</a></li>
					<li><a class="menu-item" href="metadata.html">Metadados</a></li>
					<li class="dropdown">
						<a class="dropdown-label menu-item" href="javascript:void(0);">Listas</a>
						<ul class="dropdown-menu list">
							<li><a class="dropdown-item" href="ol.html">Lista Ordenada</a></li>
							<li><a class="dropdown-item" href="ul.html">Lista Não Ordenada</a></li>
						</ul>
					</li>
					<li><a class="menu-item" href="layout.html">Layout</a></li>
					<li><a class="menu-item" href="contact.html">Fale Conosco</a></li>
				</ul>
			</nav>
    	`
	}

	connectedCallback() {
		this.setupNavBar()
		this.setupMobileMenu()
		this.setupDropdown()
	}

	setupNavBar() {
		const currentPage = window.location.pathname.split('/').pop()

		this.shadowRoot.querySelectorAll('.menu-item').forEach(item => {
			const link = item.getAttribute('href')

			if (link === currentPage) {
				item.classList.add('active')
			} else {
				item.classList.remove('active')
			}
		})
	}

	setupDropdown() {
		this.shadowRoot.querySelectorAll('.dropdown-label').forEach(item => {
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

	toggleMenu() {
		const isOpen = this.menuBackdrop.classList.contains('show')

		this.menuBackdrop.classList.toggle('show', !isOpen)
		this.openMenuButton.setAttribute('aria-expanded', String(!isOpen))
		this.menuBackdrop.setAttribute('aria-hidden', String(isOpen))
	}

	setupMobileMenu() {
		this.openMenuButton = this.shadowRoot.querySelector('#menu-button')
		this.menuBackdrop = this.shadowRoot.querySelector('#mobile-menu')

		this.openMenuButton.addEventListener('click', () => this.toggleMenu())
		this.menuBackdrop.addEventListener('click', e => {
			if (e.target === e.currentTarget) {
				this.toggleMenu()
			}
		})
	}
}

customElements.define('fatec-nav', FatecNav)
