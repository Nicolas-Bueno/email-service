# Serviço de E-mail com Failover (Desafio de Codificação da Uber)

## Visão Geral
Este é um serviço de e-mail que fornece uma abstração entre dois provedores de serviços de e-mail diferentes: Amazon SES. Ele foi projetado para ser resiliente a falhas, permitindo que o serviço mude automaticamente para o outro provedor em caso de falha. Isso garante alta disponibilidade e confiabilidade para seus clientes.

## Configuração

Antes de usar o serviço, você precisará configurar suas credenciais para os provedores de serviços de e-mail. Aqui está como configurar as credenciais para Amazon SES:

1. Crie uma conta de teste na Amazon SES, se ainda não tiver uma.

2. Crie um usuário IAM na AWS com permissões para enviar e-mails usando o Amazon SES. Anote as credenciais desse usuário.

3. Configure as credenciais do usuário IAM em um arquivo de configuração, como `config.json`, com a seguinte estrutura:

```json
{
  "ses": {
    "accessKeyId": "SUA_ACCESS_KEY_ID",
    "secretAccessKey": "SUA_SECRET_ACCESS_KEY",
    "region": "SUA_REGIAO_DA_AWS"
  }
}

Substitua SUA_ACCESS_KEY_ID, SUA_SECRET_ACCESS_KEY e SUA_REGIAO_DA_AWS pelas suas próprias informações.

Uso
Para enviar e-mails, você pode chamar a API do serviço de e-mail da seguinte maneira:

# Exemplo de uso em Python

from email_service import EmailService

# Configurações
config = {
    "ses": {
        "accessKeyId": "SUA_ACCESS_KEY_ID",
        "secretAccessKey": "SUA_SECRET_ACCESS_KEY",
        "region": "SUA_REGIAO_DA_AWS"
    }
}

# Crie uma instância do serviço de e-mail
email_service = EmailService(config)

# Envie um e-mail
result = email_service.send_email(
    from_address="seu_email@dominio.com",
    to_address="destinatario@dominio.com",
    subject="Assunto do E-mail",
    body="Corpo do E-mail"
)

if result:
    print("E-mail enviado com sucesso!")
else:
    print("Falha no envio do e-mail. O failover para outro provedor será tentado automaticamente.")

Failover
O serviço foi projetado para alternar automaticamente para outro provedor de e-mail em caso de falha na entrega do e-mail. Não é necessário fazer nada manualmente. O serviço fará a troca automaticamente e tentará enviar o e-mail novamente.

Suporte a Outros Provedores
Para adicionar suporte a outro provedor de e-mail, você precisará criar uma classe que implemente a mesma interface usada para o Amazon SES. Isso permitirá que o serviço de e-mail funcione com vários provedores de e-mail.

Contribuição
Sinta-se à vontade para contribuir para este projeto. Você pode adicionar suporte a mais provedores de e-mail, melhorar o tratamento de erros ou adicionar recursos adicionais.

Licença
Este projeto é licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter detalhes.

Nota: Lembre-se de substituir os marcadores de posição (como SUA_ACCESS_KEY_ID e SUA_SECRET_ACCESS_KEY) pelas informações reais e de fornecer detalhes específicos sobre o outro provedor de e-mail que você deseja suportar.


