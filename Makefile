_start:
	docker-compose up --build livraria-lello-app

webpack-watch:
	cd webapp && npm install && npm run watch

webpack-build:
	cd webapp && npm install && npm run

launch-services-developing: up-containers webpack-watch

launch-services: up-containers

up-containers:
	docker-compose build livraria-lello-mysql \

	docker-compose run livraria-lello-dependencies dockerize \
		-wait tcp://livraria-lello-mysql:3306 \
		-timeout 360s \
		echo "Services running"

start: launch-services _start