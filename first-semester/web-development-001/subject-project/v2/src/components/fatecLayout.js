class FatecLayout extends HTMLElement {
	constructor() {
		super()

		this.attachShadow({ mode: 'open' })

		this.shadowRoot.innerHTML = `
			<link rel="stylesheet" href="src/styles/global.css" />
          	<fatec-header></fatec-header>
			<fatec-nav></fatec-nav>
			<main id="main">
				<slot></slot>
			</main>
			<fatec-footer></fatec-footer>
    	`
	}
}

customElements.define('fatec-layout', FatecLayout)
