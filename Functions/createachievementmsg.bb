Function createachievementmsg.achievementmsg(arg0%, arg1$)
    Local local0.fps_settings
    Local local1.achievementmsg
    local0 = (First fps_settings)
    local1 = (New achievementmsg)
    local1\Field0 = arg0
    local1\Field1 = arg1
    local1\Field2 = 0.0
    local1\Field3 = local0\Field3[$01]
    local1\Field4 = currachvmsgid
    currachvmsgid = (currachvmsgid + $01)
    Return local1
    Return Null
End Function
