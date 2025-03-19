## Documentação da API Task Manager

Esta API permite a criação, listagem e busca de tarefas.

---

### **Retorna todas as tarefas**
```http
GET /tasks
```
**Resposta:**
```json
[
  {
    "title": "Finalizar projeto",
    "description": "Entregar até sexta",
    "status": "PENDING",
    "priority": "HIGH"
  }
]
```

---

### **Retorna uma tarefa pelo ID**
```http
GET /tasks/{id}
```
| Parâmetro   | Tipo   | Descrição |
| :---------- | :----- | :------------------------------- |
| `id`        | `Long` | **Obrigatório**. O ID da tarefa desejada |

**Resposta:**
```json
{
  "title": "Finalizar projeto",
  "description": "Entregar até sexta",
  "status": "PENDING",
  "priority": "HIGH"
}
```

**Erro:**
```json
{
  "message": "Tarefa com ID: {id} Não encontrada"
}
```

---

### **Cria uma nova tarefa**
```http
POST /tasks/create
```
**Corpo da requisição:**
```json
{
  "title": "Nova tarefa",
  "description": "Detalhes da tarefa",
  "status": "PENDING",
  "priority": "MEDIUM"
}
```

**Resposta:**
```json
{
  "title": "Nova tarefa",
  "description": "Detalhes da tarefa",
  "status": "PENDING",
  "priority": "MEDIUM"
}
```

**Erro:**
```json
{
  "message": "Os campos title, description e priority são obrigatórios"
}
```

---

## **Tratamento de Erros**

### **Tarefa não encontrada**
Se a tarefa solicitada pelo ID não existir, a API retornará:
```json
{
  "message": "Tarefa com ID: {id} Não encontrada"
}
```

### **Erro ao criar tarefa com campos nulos**
Se algum campo obrigatório estiver ausente:
```json
{
  "message": "Os campos title, description e priority são obrigatórios"
}
```

