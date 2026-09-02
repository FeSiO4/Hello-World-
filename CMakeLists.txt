cmake_minimum_required(VERSION 3.16)
project(HelloWorld CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# GUI subsystem so double-clicking shows the MessageBox without a console flash
add_executable(hello-world WIN32 main.cpp)
