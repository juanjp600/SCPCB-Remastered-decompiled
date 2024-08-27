Function renderachievementmsg%()
    Local local0.fonts
    Local local1.achievementmsg
    Local local2.achievementmsg
    Local local3#
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    local0 = (First fonts)
    local3 = ((Float graphicheight) / 768.0)
    local4 = (Int (264.0 * local3))
    local5 = (Int (84.0 * local3))
    For local1 = Each achievementmsg
        If (0.0 <> local1\Field3) Then
            local6 = (Int (local1\Field2 + (Float graphicwidth)))
            local7 = $00
            For local2 = Each achievementmsg
                If (local2 <> local1) Then
                    If (local2\Field4 > local1\Field4) Then
                        local7 = (local7 + local5)
                    EndIf
                EndIf
            Next
            drawframe(local6, local7, local4, local5, $00, $00)
            color($00, $00, $00)
            rect((Int ((10.0 * local3) + (Float local6))), (Int ((10.0 * local3) + (Float local7))), (Int (64.0 * local3)), (Int (64.0 * local3)), $01)
            drawimage(achvimg(local1\Field0), (Int ((10.0 * local3) + (Float local6))), (Int ((10.0 * local3) + (Float local7))), $00)
            color($32, $32, $32)
            rect((Int ((10.0 * local3) + (Float local6))), (Int ((10.0 * local3) + (Float local7))), (Int (64.0 * local3)), (Int (64.0 * local3)), $00)
            color($FF, $FF, $FF)
            aasetfont(local0\Field0[$00])
            rowtext(((scplang_getphrase("achievements.achunlocked") + " -    ") + local1\Field1), (Int ((84.0 * local3) + (Float local6))), (Int ((10.0 * local3) + (Float local7))), (Int ((Float local4) - (94.0 * local3))), (Int ((Float local7) - (20.0 * local3))), $00, 1.0)
        EndIf
    Next
    Return $00
End Function
