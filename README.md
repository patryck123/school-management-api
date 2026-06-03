# 🏫 School Management API

Sistema de gestão escolar com alunos, cursos e matrículas.

## 📋 Sobre o Projeto

API completa para gerenciar uma instituição de ensino. Controla o cadastro de alunos, os cursos oferecidos e as matrículas. Impede matrícula duplicada do mesmo aluno no mesmo curso.

## ✨ Funcionalidades

- ✅ Cadastrar e gerenciar alunos
- ✅ Cadastrar e gerenciar cursos (com carga horária)
- ✅ Matricular aluno em curso
- ✅ Cancelar matrícula
- ✅ Listar alunos matriculados em um curso
- ✅ Listar cursos de um aluno
- ✅ Validação: impede matrícula duplicada
- ✅ Status do aluno: ACTIVE, INACTIVE, GRADUATED

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET/POST | `/api/students` | Listar / Cadastrar alunos |
| GET/PUT/DELETE | `/api/students/{id}` | Gerenciar aluno |
| GET/POST | `/api/courses` | Listar / Cadastrar cursos |
| GET/PUT/DELETE | `/api/courses/{id}` | Gerenciar curso |
| POST | `/api/courses/{id}/enroll/{studentId}` | Matricular aluno |
| DELETE | `/api/courses/{id}/enroll/{studentId}` | Cancelar matrícula |

## 🛠️ Tecnologias

- Java 17 · Spring Boot 3.2 · PostgreSQL · Maven · Lombok
