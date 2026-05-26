# 📱 AppLogin - Sistema de Autenticação Android

Uma aplicação Android moderna com sistema de **registro de usuários** e **autenticação** utilizando banco de dados SQLite.

---

## 📋 Índice

- [Visão Geral](#visão-geral)
- [Requisitos](#requisitos)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Instalação](#instalação)
- [Como Usar](#como-usar)
- [Funcionalidades](#funcionalidades)
- [Classes e Métodos](#classes-e-métodos)
- [Banco de Dados](#banco-de-dados)
- [Dicas de Desenvolvimento](#dicas-de-desenvolvimento)

---

## 🎯 Visão Geral

**AppLogin** é um projeto educacional que demonstra:
- Criação de interfaces com ConstraintLayout
- Implementação de banco de dados SQLite
- Sistema de cadastro e login de usuários
- Validação de senhas
- Navegação entre Activities

---

## 📦 Requisitos

- **Android Studio** 4.0 ou superior
- **Java** 8 ou superior
- **API Level** mínimo: 21 (Android 5.0)
- **Gradle** 6.0 ou superior

---

## 📁 Estrutura do Projeto

```
AppLogin/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/br/ulbra/appagenda/
│   │   │   │   ├── MainActivity.java          # Tela inicial
│   │   │   │   ├── LoginActivity.java         # Tela de login
│   │   │   │   ├── RegistrarActivity.java     # Tela de cadastro
│   │   │   │   └── DBHelper.java              # Gerenciamento do BD
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml      # Layout inicial
│   │   │   │   │   ├── activity_login.xml     # Layout de login
│   │   │   │   │   └── activity_registrar.xml # Layout de cadastro
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   └── styles.xml
│   │   │   │   └── drawable/ (ícones e imagens)
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
└── README.md
```

---

## 🚀 Instalação

### 1. **Clonar ou Baixar o Projeto**
```bash
git clone https://github.com/seu-usuario/AppLogin.git
cd AppLogin
```

### 2. **Abrir no Android Studio**
- File > Open > Selecione a pasta do projeto
- Aguarde o Gradle sincronizar

### 3. **Configurar Emulador ou Dispositivo Físico**
- Tools > AVD Manager (para criar emulador)
- Ou conecte um dispositivo via USB com Debug ativado

### 4. **Build e Execução**
```bash
# Build do projeto
./gradlew build

# Executar na emulador/dispositivo
./gradlew installDebug
```

---

## 📲 Como Usar

### **Tela 1 - Inicial (MainActivity)**
1. Abra o aplicativo
2. Clique em **"ENTRAR"** para fazer login
3. Clique em **"CADASTRAR"** para criar uma nova conta

### **Tela 2 - Cadastro (RegistrarActivity)**
1. Digite um **nome de usuário** (username)
2. Digite uma **senha**
3. **Confirme a senha** digitando novamente
4. Clique em **"SALVAR"**
5. Sucesso! Agora você pode fazer login

### **Tela 3 - Login (LoginActivity)**
1. Digite seu **username**
2. Digite sua **senha**
3. Clique em **"ENTRAR"**
4. Se os dados forem corretos, login bem-sucedido!

---

## ✨ Funcionalidades

✅ **Tela Inicial Atraente**
- Logo personalizado
- Botões com ícones
- Design responsivo

✅ **Sistema de Cadastro**
- Validação de campos vazios
- Verificação de senhas iguais
- Mensagens de feedback

✅ **Sistema de Login**
- Autenticação segura
- Validação de credenciais
- Mensagens de erro detalhadas

✅ **Banco de Dados SQLite**
- Armazenamento local
- Persistência de dados
- Operações CRUD

---

## 🔧 Classes e Métodos

### **MainActivity.java**
Responsável pela tela inicial com botões de navegação.

```java
public class MainActivity extends AppCompatActivity {
    Button btEntrar, btRegistrar;
    
    // Abre LoginActivity ao clicar em "ENTRAR"
    // Abre RegistrarActivity ao clicar em "REGISTRAR"
}
```

**Métodos principais:**
- `onCreate()` - Inicializa a activity

---

### **DBHelper.java**
Gerencia todas as operações com banco de dados.

```java
public class DBHelper extends SQLiteOpenHelper {
    // Banco: BancoDados.db
    // Tabela: utilizador (username, password)
}
```

**Métodos principais:**
- `onCreate(SQLiteDatabase db)` - Cria tabelas
- `criarUtilizador(String userName, String password)` - Cadastra usuário
- `validarLogin(String userName, String password)` - Autentica usuário

---

### **RegistrarActivity.java**
Tela de cadastro de novos usuários.

```java
public class RegistrarActivity extends AppCompatActivity {
    EditText edNome, edUser, edPas1, edPas2;
    Button btSalvar;
    DBHelper db;
}
```

**Validações:**
- Username não pode ser vazio
- Senhas não podem ser vazias
- Senhas devem ser iguais

---

### **LoginActivity.java**
Tela de autenticação de usuários.

```java
public class LoginActivity extends AppCompatActivity {
    EditText edLogin, edPass;
    Button btLogin;
    DBHelper db;
}
```

**Validações:**
- Username obrigatório
- Senha obrigatória
- Credenciais devem existir no BD

---

## 🗄️ Banco de Dados

### **Tabela: utilizador**

| Campo | Tipo | Restrição |
|-------|------|-----------|
| username | TEXT | PRIMARY KEY |
| password | TEXT | NOT NULL |

### **Operações SQL**

**Criar usuário:**
```sql
INSERT INTO utilizador (username, password) VALUES (?, ?);
```

**Autenticar:**
```sql
SELECT * FROM utilizador WHERE username=? AND password=?;
```

---

## 💡 Dicas de Desenvolvimento

### **Melhorias Sugeridas**

1. **Segurança de Senha**
   ```java
   // Hash de senha com BCrypt
   String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
   ```

2. **Validação de Email**
   ```java
   if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
       Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show();
   }
   ```

3. **Campos Obrigatórios**
   ```java
   if (userName.isEmpty() || password.isEmpty()) {
       Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
       return;
   }
   ```

4. **Feedback Visual**
   - Adicionar ProgressBar durante validação
   - Mostrar/ocultar senha com ícone
   - Validação em tempo real

5. **Gerenciamento de Sessão**
   ```java
   // SharedPreferences para manter usuário logado
   SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
   prefs.edit().putString("username", username).apply();
   ```

---

## 📝 Exemplo de Uso Completo

### **Cadastrar um usuário**
1. Clique em "CADASTRAR"
2. Digite: username = `aluno_saolucas`
3. Digite: senha = `senha123`
4. Confirme: `senha123`
5. Clique em "SALVAR"
6. Mensagem: "Registro OK"

### **Fazer Login**
1. Clique em "ENTRAR"
2. Digite: `aluno_saolucas`
3. Digite: `senha123`
4. Clique em "ENTRAR"
5. Mensagem: "Login OK !!"

---

## 🐛 Troubleshooting

### **"Classe não encontrada"**
- Certifique-se de que os nomes das classes estão corretos no AndroidManifest.xml
- Sincronize o Gradle: File > Sync Now

### **"Erro no banco de dados"**
- Limpe o cache: Build > Clean Project
- Reconstrua: Build > Rebuild Project
- Desinstale o app do dispositivo antes de reinstalar

### **"Activity não inicia"**
- Verifique os IDs dos componentes no XML
- Confirme que os layouts existem em res/layout/

---

## 📚 Referências

- [Android Developers - SQLiteOpenHelper](https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper)
- [Android Developers - Intent](https://developer.android.com/reference/android/content/Intent)
- [Android Developers - Activities](https://developer.android.com/guide/components/activities)

---

## 📄 Licença

Este projeto é educacional e pode ser utilizado livremente para fins de aprendizado.

---

## 👨‍💻 Autor

Desenvolvido como parte do curso de **Desenvolvimento Android** no SENAC.

**Criado por:** Lucas Santos Branco  
**Data:** 2026  
**Status:** ✅ Completo

---

## 📞 Suporte

Dúvidas ou sugestões? Entre em contato com seu professor ou instrutor!

---

**Obrigado por usar AppLogin!** 🎉
