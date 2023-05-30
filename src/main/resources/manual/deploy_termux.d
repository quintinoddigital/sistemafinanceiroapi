# Realizar deploy no Android

	1) Instalar TERMUX 
	
		- Realizar download no site https://f-droid.org
	
	2) Instalar .apk
	
	3) Acessar TERMUX
	
	4) Executar comandos de atualização
	
		$ apt update && apt upgrade

		$ pkg update
		
	5) Verificar todos os pacotes disponíveis
	
		$ pkg list-all
		
	6) Instalar Programas Necessários
	
		6.1) Instalar OPENSSH para acesso remoto
		
			$ pkg install openssh
			
		6.2) Definir senha do dispositico
		
			$ passwd
	
	7) Configurar acesso Remoto via SSH
	
		7.1) Executar SSH
		
			$ sshd
			
	8) Pegar IP Android (em INET)
	
		$ ifcondig 
		$ whoami
		
	9) Em dispositivo remoto acessar 
	
		$ ssh <USUARIO>@<IP> -p 8022
		
		$ ssh u0_a459@192.168.1.99 -p 8022
		
	10) Demais Programas
	
		$ pkg install git
		$ pkg install openjkd-17
		$ pkg install maven
		$ pkg install postgresql
		
		10.1) Configurar PostgreSQL
		
			$ mkdir -p $PREFIX/var/lib/postgresql
			$ initdb $PREFIX/var/lib/postgresql
			$ pg_ctl -D /data/data/com.termux/files/usr/var/lib/postgresql -l logfile start
			$ createdb postgres;
			$ psql postgres;
			
	11) Criar branch da TAG
		
		$ git tag -l
			
		$ git checkout tags/v1.0.0.0-BETA -b v1.0.0.0-BETA
		
	12) Configurar FISH para o TERMUX
	
		- https://github.com/oh-my-fish/oh-my-fish/blob/master/README.md
		- https://www.youtube.com/watch?v=M0kiKzProCU
	
		
		