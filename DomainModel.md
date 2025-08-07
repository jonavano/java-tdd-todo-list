## Domain Model

- I want to add tasks to my todo list.
- I want to see all the tasks in my todo list.
- I want to change the status of a task between incomplete and complete.
- I want to be able to get only the complete tasks.
- I want to be able to get only the incomplete tasks.
- I want to search for a task and receive a message that says it wasn't found if it doesn't exist.
- I want to remove tasks from my list.
- I want to see all the tasks in my list ordered alphabetically in ascending order.
- I want to see all the tasks in my list ordered alphabetically in descending order.


| Classes    | Methods                           | Scenario               | Outputs                                                                        |
| ---------- | --------------------------------- | ---------------------- | ------------------------------------------------------------------------------ |
| `TodoList` | `TodoList()`                      | create method          | todoList object with empty map                                                 |
|            | addTask(String taskName)          | If string is not blank | task gets added and the boolean for finished is set to false and true returned |
|            |                                   | if string is empty     | nothing gets added and false returned                                          |
|            | getTodoList()                     | List is empty          | empty list is returned                                                         |
|            |                                   | list is not empty      | returns the todolist                                                           |
|            | setDone(String taskName)          | is valid task          | task is state is set to done and true is returned                              |
|            |                                   | else                   | false is returned                                                              |
|            | getCompletedTasks()               | any state              | list of all completed tasks is returned, can be empty                          |
|            | getIncompletedTasks()             | any state              | list of all incompleted tasks is returned, can be empty                        |
|            | findTask(String taskName)         | valid taskname         | String returned "Task found"                                                   |
|            |                                   | not valid taskName     | String return "Task not found"                                                 |
|            | removeTask(String taskName)       | valid task             | returns true and task is removed                                               |
|            |                                   | non valid task         | returns false and nothing happens                                              |
|            | getSortedTasks(boolean ascending) | if ascending is true   | returns list ascending order                                                   |
|            |                                   | if ascending is false  | returns list in descending order                                               |
