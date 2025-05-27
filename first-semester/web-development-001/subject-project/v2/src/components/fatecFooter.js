class FatecFooter extends HTMLElement {
	constructor() {
		super()

		this.attachShadow({ mode: 'open' })

		this.shadowRoot.innerHTML = `
			<link rel="stylesheet" href="src/styles/global.css" />
			<link rel="stylesheet" href="src/styles/footer.css" />
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
}

customElements.define('fatec-footer', FatecFooter)
