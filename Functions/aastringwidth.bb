Function aastringwidth%(arg0$)
    Local local0.aafont
    Local local1%
    Local local2%
    Local local3%
    local0 = (Object.aafont aaselectedfont)
    If ((aatextenable And local0\Field10) <> 0) Then
        local1 = $00
        For local2 = $01 To len(arg0) Step $01
            local3 = asc(mid(arg0, local2, $01))
            If (((local3 >= $00) And (local3 <= $7F)) <> 0) Then
                local1 = ((local0\Field4[local3] + local1) - $02)
            EndIf
        Next
        Return (local1 + $02)
    Else
        setfont(local0\Field6)
        Return stringwidth(arg0)
    EndIf
    Return $00
End Function
