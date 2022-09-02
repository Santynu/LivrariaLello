start:
	docker-compose up --build livraria-lello-app

webpack-watch:
	cd webapp && npm install && npm run watch