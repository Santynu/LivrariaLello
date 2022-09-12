start:
	docker-compose up --build livraria-lello-app

webpack-watch:
	cd webapp && npm install && npm run watch

launch-services: up-containers webpack-watch

up-containers:
	docker-compose build livraria-lello-mysql
	docker-compose run livraria-lello-mysql