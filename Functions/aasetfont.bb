Function aasetfont%(arg0%)
    Local local0.aafont
    Local local1%
    aaselectedfont = arg0
    local0 = (Object.aafont aaselectedfont)
    If ((aatextenable And local0\Field10) <> 0) Then
        For local1 = $00 To $95 Step $01
            entitytexture(aatextsprite[local1], local0\Field0, $00, $00)
        Next
    EndIf
    Return $00
End Function
