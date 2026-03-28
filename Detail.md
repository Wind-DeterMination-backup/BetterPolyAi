# 工作区总览

这一层是整个 BetterPolyAi 仓库的根。它把源码、构建脚本、发布说明、Gradle 状态目录、构建产物和手工分发目录放在同一层，便于开发时从一个入口同时处理编码、打包和发版。

## 这一层做了什么

- `build.gradle` 定义了项目真正的构建逻辑：Java 8 兼容、Mindustry 依赖、`jar`/`jarDesktop`/`jarAndroid`/`deploy` 等任务、D8 查找逻辑，以及把产物复制到工作区外 `构建/<project.name>` 目录的动作。
- `settings.gradle` 只负责确定 Gradle 根项目名为 `betterPolyAi`，这个名字会影响 `project.name`、部分构建目录命名和 D8 输入包名。
- `README.md` 与 `README_EN.md` 给出中英文使用说明，说明这是从 MindustryX 抽离出来的客户端 Poly 建造辅助模组。
- `CHANGELOG.md` 记录版本历史，目前只看到 `v0.1.0`，和 GitHub Actions 中的语义化版本升级流程相互呼应。
- `LICENSE` 是 GPLv3 全文，表示仓库分发时采用强 copyleft 许可。
- `.gitignore` 明确忽略 `.gradle/`、`build/`、`out/`、`.idea/` 和 `*.iml`，所以当前工作区里出现的 `.gradle/` 与 `build/` 更像本地构建痕迹，而不是计划提交的源码内容。

## 实现方式

源码真正从 `src/` 起步，构建由 Gradle 驱动，发布自动化放在 `.github/`。本地构建后会在 `build/` 生成编译产物、中间文件和问题报告；额外还有一个 `dist/` 目录存放现成分发包。当前 `git status` 只把 `dist/` 标为未跟踪，说明它更像手工保留的输出目录，不是稳定版本控制内容。

## 和其他层级的关系

- `src/` 是唯一的手写业务源码来源。
- `.github/` 消费根目录脚本与源码，执行自动发版。
- `.gradle/` 只保存 Gradle 状态，不参与模组运行时。
- `build/` 是从根目录脚本和 `src/` 推导出的本地构建工作区。
- `dist/` 是面向最终使用者的包目录，但其内容目前和 `build/libs/` 不完全一致：`dist` 里的两个包都包含 `classes.dex`，而当前 `build/libs/` 的桌面包与 zip 包没有这个文件。
