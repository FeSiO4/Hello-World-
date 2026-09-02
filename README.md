# Hello-World-

Minimal **C++** program built into a Windows `.exe` by **GitHub Actions** on every `git push`.

Purpose: verify the pipeline **local `git push` → GitHub Actions → Windows .exe artifact**.

## Files

```
main.cpp            trivial C++ "Hello" program
CMakeLists.txt      CMake build (C++17, exe `hello-world`)
.github/workflows/build-cpp-exe.yml   cloud build on windows-latest -> .exe artifact
```

## How the cloud build works

1. You commit + `git push origin main`
2. Actions (windows-latest) runs: `cmake -S . -B build` → `cmake --build build --config Release`
3. Produces `hello-world.exe`, runs it (sanity check), and uploads it as an artifact
4. Grab it at repo → **Actions** → run → **Artifacts**

## Run locally

```bash
cmake -S . -B build
cmake --build build --config Release
build/Release/hello-world.exe
```
