Function reloadaafont%()
    Local local0.aafont
    Local local1%
    Local local2%
    Local local3%
    If (aatextenable <> 0) Then
        initaafont()
        For local0 = Each aafont
            If (local0\Field10 <> 0) Then
                local0\Field0 = createtexture($400, $400, $03, $01)
                lockbuffer(imagebuffer(local0\Field1, $00))
                lockbuffer(texturebuffer(local0\Field0, $00))
                For local1 = $00 To $3FF Step $01
                    For local2 = $00 To local0\Field9 Step $01
                        local3 = (readpixelfast(local1, local2, imagebuffer(local0\Field1, $00)) Shl $18)
                        writepixelfast(local1, local2, ($FFFFFF + local3), texturebuffer(local0\Field0, $00))
                    Next
                Next
                unlockbuffer(texturebuffer(local0\Field0, $00))
                unlockbuffer(imagebuffer(local0\Field1, $00))
            EndIf
        Next
    EndIf
    Return $00
End Function
