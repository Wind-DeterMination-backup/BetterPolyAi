# src/main/java/betterpolyai/features 层说明

这一层是项目最核心的功能代码区，真正决定 Poly 建造辅助怎么工作。

## 当前文件职责

- `PolyAiFeature.java`：管理设置键、按键绑定、设置刷新频率、开关状态、提示文字，以及在每帧更新时判断当前玩家单位是否应该交给自定义 AI 接管。
- `PlayerPlanBuilderAI.java`：继承 `AIController`，只围绕当前单位的建造计划工作；会校验待建方块或拆除请求是否合法，按 `buildGapTiles` 控制靠近距离，并在必要时回退到 `PrebuildAI`、`FlyingAI`、`GroundAI`。

## 实现细节

- `PolyAiFeature` 每 0.25 秒刷新一次设置，说明作者愿意接受轻量轮询，换取设置即时生效而不需要额外事件绑定。
- 默认开关键是关闭的，快捷键是 `P`。
- `buildGapTiles` 限制在 0 到 30 之间，且逻辑是“太远才靠近，已在范围内不会后退”，这能减少单位来回摆动。
- `PlayerPlanBuilderAI` 明确只消费 `unit.buildPlan()`，不会主动替别人生成计划，也不会扩散到其他玩家的建造队列。

## 和其他层级的关系

- 上游由 `BetterPolyAiMod` 初始化。
- 下游行为文案来自 `src/main/resources/bundles` 中的 key。
