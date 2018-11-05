
function addtag(input, reviewId) {
	addTagButton.addEventListener('click', (input, reviewId) => {
		const xhttp = new XMLHttpRequest()
		// Sets behavior for when the AJAX request is complete
		console.log(xhttp);
		xhttp.onreadystatechange = function() {
			// Checks the ready state and http status code
			if (this.readyState == 4 && this.status == 200) {
				// Typical action to be performed when the document is ready:
				console.log(JSON.parse(this.responseText))
				p.innerHTML = original;
				JSON.parse(this.responseText).forEach(tag =>{
					p.innerHTML = p.innerHTML + `
						<a href = "/tag/${tag.id}" class="a${tag.id}">${tag.tagName}</a> <button class="button${tag.id}">X</button>
					`;
					document.querySelector(`.button${tag.id}`).addEventListener('click', () => {
	 						fetch(`/api/review/${reviewId}/tags/remove`, {
	 							method: 'POST',
	 							body:	JSON.stringify({
									tagName: tag.tagName
	 							})
	 						}).then(() => {
	 							document.querySelector(`.a${tag.id}`).remove();
	 							document.querySelector(`.button${tag.id}`).remove();
	 						})
	 					})
				})
			}
		}
		xhttp.open('POST', `/api/reviews/${window.location.pathname.split('/')[2]}/tags/add`, true)
		const body = JSON.stringify({
					tagName: input.value
				})
		xhttp.send(body)
	})
}
