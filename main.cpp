// Windows GUI program: shows a message box, closes only when OK is clicked.
// Built on GitHub Actions (windows-latest) into a .exe on every git push.
#ifndef UNICODE
#define UNICODE
#endif
#ifndef _UNICODE
#define _UNICODE
#endif
#include <windows.h>

int WINAPI wWinMain(HINSTANCE, HINSTANCE, PWSTR, int) {
    MessageBoxW(nullptr,
                L"Hello from a GitHub-Actions-built C++ exe!\n"
                L"local git push -> cloud Actions -> .exe : OK",
                L"Hello-World (C++)",
                MB_OK | MB_ICONINFORMATION);
    return 0;
}
