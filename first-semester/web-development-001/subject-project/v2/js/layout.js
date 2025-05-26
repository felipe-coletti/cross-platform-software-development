class FatecLayout extends HTMLElement {
	constructor() {
		super()

		this.originalChildren = Array.from(this.children)

		this.innerHTML = `
          	<header id="header">
				<div class="container">
					<a class="logo" href="index.html" title="Voltar para o início">
						<img
							class="logo-image"
							src="assets/images/logo-fatec.png"
							alt="Logo branca da Fatec da Zona leste"
						/>
					</a>
					<a
						class="logo"
						href="https://www.cps.sp.gov.br/"
						title="Ir para Centro Paula Souza"
						target="_blank"
						rel="noopener"
					>
						<img class="logo-image" src="assets/images/logo-cps.png" alt="Logo branca do Centro Paula Souza" />
					</a>
					<a
						class="logo"
						href="https://sp.gov.br/sp"
						title="Ir para Governo do Estado de São Paulo"
						target="_blank"
						rel="noopener"
					>
						<img
							class="logo-image"
							src="assets/images/logo-governo-do-estado-sp.png"
							alt="Logo branca do Voverno do Estado de São Paulo"
						/>
					</a>
				</div>
			</header>
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
			<main id="main"></main>
			<footer id="footer" class="flex-container">
				<div class="container">
					<p class="paragraph">
						Este é um projeto educacional desenvolvido como exercício acadêmico. Não se trata do site oficial da
						Fatec Ourinhos.
					</p>
					<p class="paragraph">&copy; 2025 Felipe Coletti</p>
				</div>
			</footer>
    	`
	}

	connectedCallback() {
		const main = this.querySelector('#main')

		this.originalChildren.forEach(child => {
			main.appendChild(child)
		})
	}
}

customElements.define('fatec-layout', FatecLayout)
