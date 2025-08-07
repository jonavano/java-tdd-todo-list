## Extension

- I want to be able to get a task by a unique ID.
- I want to update the name of a task by providing its ID and a new name.
- I want to be able to change the status of a task by providing its ID.
- I want to be able to see the date and time that I created each task.


| Classes    | Methods                            | Scenario               | Outputs                                                                        |
| ---------- | ---------------------------------- | ---------------------- | ------------------------------------------------------------------------------ |
| `TodoList` | `TodoList()`                       | create method          | todoList object with empty map                                                 |
|            | addTask(String taskName)           | If string is not blank | task gets added and the boolean for finished is set to false and true returned |
|            |                                    | if string is empty     | nothing gets added and false returned                                          |
|            | getTodoList()                      | List is empty          | empty list is returned                                                         |
|            |                                    | list is not empty      | returns the todolist                                                           |
|            | setDone(String taskName)           | is valid task          | task is state is set to done and true is returned                              |
|            |                                    | else                   | false is returned                                                              |
|            | setDone(int id)                    | id is valid            | state is set to true and returned                                              |
|            |                                    | id is not valid        | false is returned                                                              |
|            | getCompletedTasks()                | any state              | list of all completed tasks is returned, can be empty                          |
|            | getIncompletedTasks()              | any state              | list of all incompleted tasks is returned, can be empty                        |
|            | findTask(String taskName)          | valid taskname         | String returned "Task found"                                                   |
|            |                                    | not valid taskName     | String return "Task not found"                                                 |
|            | removeTask(String taskName)        | valid task             | returns true and task is removed                                               |
|            |                                    | non valid task         | returns false and nothing happens                                              |
|            | getSortedTasks(boolean ascending)  | if ascending is true   | returns list ascending order                                                   |
|            |                                    | if ascending is false  | returns list in descending order                                               |
|            | getTask(int uniqueId)              | id exists              | task is returned                                                               |
|            |                                    | id does not exist      | null is returned                                                               |
|            | updateName(int id, String newName) | if id exists           | return true                                                                    |
|            |                                    | id does not exist      | return false                                                                   |

