Function achievementtooltip%(arg0%)
    Local local0#
    Local local1.fonts
    Local local2%
    Local local3%
    local0 = ((Float graphicheight) / 768.0)
    local1 = (First fonts)
    aasetfont(local1\Field0[$02])
    local2 = aastringwidth(achievementstrings(arg0))
    aasetfont(local1\Field0[$00])
    If (aastringwidth(achievementdescs(arg0)) > local2) Then
        local2 = aastringwidth(achievementdescs(arg0))
    EndIf
    local2 = (Int ((20.0 * menuscale) + (Float local2)))
    local3 = (Int (38.0 * local0))
    color($19, $19, $19)
    rect((Int ((20.0 * menuscale) + (Float scaledmousex()))), (Int ((20.0 * menuscale) + (Float scaledmousey()))), local2, local3, $01)
    color($96, $96, $96)
    rect((Int ((20.0 * menuscale) + (Float scaledmousex()))), (Int ((20.0 * menuscale) + (Float scaledmousey()))), local2, local3, $00)
    aasetfont(local1\Field0[$02])
    aatext((Int (((20.0 * menuscale) + (Float scaledmousex())) + (Float (local2 Sar $01)))), (Int ((35.0 * menuscale) + (Float scaledmousey()))), scplang_getphrase(achievementstrings(arg0)), $01, $01, 1.0)
    aasetfont(local1\Field0[$00])
    aatext((Int (((20.0 * menuscale) + (Float scaledmousex())) + (Float (local2 Sar $01)))), (Int ((55.0 * menuscale) + (Float scaledmousey()))), scplang_getphrase(achievementdescs(arg0)), $01, $01, 1.0)
    Return $00
End Function
