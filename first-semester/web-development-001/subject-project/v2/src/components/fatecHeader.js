class FatecHeader extends HTMLElement {
	constructor() {
		super()

		this.attachShadow({ mode: 'open' })

		this.shadowRoot.innerHTML = `
			<link rel="stylesheet" href="src/styles/global.css" />
			<link rel="stylesheet" href="src/styles/header.css" />
			<header id="header">
				<div class="container">
					<a class="logo" href="index.html" title="Voltar para o início">
						<img
							class="logo-image"
							src="src/assets/images/logo-fatec.png"
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
						<img class="logo-image" src="src/assets/images/logo-cps.png" alt="Logo branca do Centro Paula Souza" />
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
							src="src/assets/images/logo-governo-do-estado-sp.png"
							alt="Logo branca do Voverno do Estado de São Paulo"
						/>
					</a>
				</div>
			</header>
		`
	}
}

customElements.define('fatec-header', FatecHeader)
