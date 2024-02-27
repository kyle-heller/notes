# Python Virtual Environments
Virtual environments are a way for developers to designate a particular directory/folder as a root for installing modules/packages of X version.

For example, say you have a project using Django 3 and another project which uses Django 2.8. If you simply try installing the required version with `pip` the previously installed version will be removed first. *However*, if you use a virtual environment you can say *this folder is for the Django 3 project* and *that folder is for the Django 2.8 project*.

## Creating a virtual environment with `venv`
Python includes a module called `venv` which manages virtual environments. To create one you type: <br><br>`python -m venv environment-name` 

"environment-name" in the above can be whatever you choose, *however*, it's a good idea to use the name `venv` or `.venv` as this will then be recognised by some code-editors (such as PyCharm and VSCode).

To make it easier to identify which virtual environment you're working with you can also pass the `prompt` argument (this will then be display in your terminal when you're within that virtual environment): <br><br>`python -m venv --prompt myproject .venv`

## Activating a virtual env
Within the folder created by the above  there is a subfolder `bin` which contains an activation script. The easiest method is to `cd` into that directory and `source` the script.

`cd venv/bin` <br>
`source activate`

## virtualenvwrapper
You can get access to some very useful additional functionality by installing the [virtualenvwrapper](https://virtualenvwrapper.readthedocs.io/en/latest/) extension for `venv`.

### Creating a virtual environment with __virtualenvwrapper__
To create a virtual environment run:<br>`mkvirtualenv [environment_name]`

### Activating a virtualenv using virtualenvwrapper
To activate a particular environment run:<br>`workon [environment_name]`

Deactivating a virtual env
To deactivate/exit an environment run:<br>`deactivate`

### See what envs are available
If you want to see what environments are available on your system just run `workon` without any parameters:<br>`workon`

Or alternatively run:<br>`lsvirtualenv`

### See more info about a specific environment
To see detailed info about about a specific environment run:<br>`showvirtualenv [environment_name]`

### Removing a virtual environment
To remove/delete an environment run:<br>`rmvirtualenv [environment_name]`

### Duplicate a virtual environment
To create a duplicate of an environment run:<br>`cpvirtualenv [environment_to_copy] [name_of_copy]`

### List all commands for virtualenvwrapper
To print a list of available commands simply run:<br>`virtualenvwrapper`

## Installing & managing multiple Python versions with __pyenv__
In order to install different versions of Python you can use a tool called [pyenv](https://github.com/pyenv/pyenv)

### See available installed versions
To see a list of installed Python versions run:<br>`pyenv versions`

`*system` is the version that was preinstalled on your system (if on Mac or Linux).

### See versions availabe to install
To see a list of the versions you can install run:<br>`pyenv install -l`

### Install a particular version
To install a specific version run:<br>`pyenv install [python-version]`

For example to install Python 3.9.5 you would type: `pyenv install 3.9.5`

### Uninstall a specific version
Simply run:<br>`pyenv uninstall [python-version]`

### Make a particular version the global default
To make a version you've installed the global default run:<br>`pyenv global [version]`
